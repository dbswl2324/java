
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
import javax.sound.midi.Receiver;
 
public class ServerBackground {
 
    private ServerSocket serverSocket; // ���� ����
    private Socket socket; // �޾ƿ� ���� ����
    private ServerGUI gui;
    private String msg;
    /** XXX 03. ����ڵ��� ������ �����ϴ� �� */ 
    private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();
 
    public void setGui(ServerGUI gui) {
        this.gui = gui;
    }
 
    public static void main(String[] args) {
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
    }
    //������ �����ɶ� �������ִ� �Լ� 
    public void setting() {
        
        try {
            
            Collections.synchronizedMap(clientMap); //���������� ���ش�.( clientMap�� ��Ʈ��ũ ó�����ִ°� ) 
            serverSocket = new ServerSocket(7500);
 
            while (true) {
                /** XXX 01.������ ���� : �湮�ڸ� ��� �޾Ƽ�, ������ ���ù��� ��� ���� */
                
                System.out.println("�����.....");
                socket = serverSocket.accept(); // ���⼭ Ŭ���̾�Ʈ ����
                System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
                
                //���⼭ ���ο� ����� ������ Ŭ������ �����ؼ� ���� ������ �־�����Ѵ�.
                Receiver receiver = new Receiver(socket);
                receiver.start();
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //���ǳ���(Ŭ���̾�Ʈ) ����� ���� 
    public void addClient(String nick, DataOutputStream out) throws IOException{
        String message=nick + "���� �����ϼ̽��ϴ�.\n";
        sendMessage(message);
        gui.appendMsg(message);
        clientMap.put(nick, out);
        
    }
    
    public void removeClient(String nick){
        String message=nick + "���� �����̽��ϴ�. \n";
        sendMessage(message);
        gui.appendMsg(message);
        clientMap.remove(nick);
    }
    
    //�޼��� ���� ���� 
    public void sendMessage (String msg){
        Iterator<String> iterator = clientMap.keySet().iterator(); //key������ �ݺ�������
        String key = "";
        
        while(iterator.hasNext()){
            key = iterator.next();// �ݺ��ڿ��� �ϳ��ϳ� Ű�� ���´�.
            try{
                clientMap.get(key).writeUTF(msg);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    // ------------------���ù�---------------------------
    class Receiver extends Thread {
        /** XXX ���ù��� ���� : ��Ʈ��ũ ������ �޾Ƽ� ��ӵ�� ������ ��. */
        private DataInputStream in; // ������ �Է� ��Ʈ��
        private DataOutputStream out; // ������ �ƿ�ǲ ��Ʈ��
        private String nick;
 
        public Receiver(Socket socket) {
            try {
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
                nick = in.readUTF();
                addClient(nick,out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
        @Override
        public void run() {
 
            try {
                while (in != null) {
                    msg = in.readUTF();// UTF�� �о���δ�.
                    sendMessage(msg);
                    gui.appendMsg(msg);
                }
            } catch (Exception e) {
                //������������ ���⼭ �����߻�. 
                removeClient(nick);
            }
        }
    }
 
}
