package nioservice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NIOServer {

    private int port;

    private Charset charset = Charset.forName("UTF-8");

    private ByteBuffer rBuffer = ByteBuffer.allocate(1024);

    private ByteBuffer sBuffter = ByteBuffer.allocate(1024);

    private Map<String, SocketChannel> clintMap = new HashMap<>();

    private static Selector selector;

    public NIOServer(int port) throws IOException {
        this.port = port;
        init();
    }

    private void init() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(port));

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动， 端口为：" + port);

    }

    public void listen(){
        while (true){
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> handle(selectionKey));
                selectionKeys.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void handle(SelectionKey selectionKey){
        try {
            if ( selectionKey.isAcceptable() ){
                ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                SocketChannel client = server.accept();
                client.configureBlocking(false);
                client.register(selector, SelectionKey.OP_READ);
                clintMap.put(getClientName(client), client);
            }
            else if ( selectionKey.isReadable() ){
                SocketChannel client = (SocketChannel) selectionKey.channel();
                rBuffer.clear();
                int bytes = client.read(rBuffer);
                if (bytes > 0){
                    rBuffer.flip();
                    String receiveText = String.valueOf(charset.decode(rBuffer));
                    System.out.println(client.toString() + ":" + receiveText);
                    dispatch(client, receiveText);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void dispatch(SocketChannel client, String info) throws IOException {

        if ( !clintMap.isEmpty() ){
            for (Map.Entry<String, SocketChannel> entry : clintMap.entrySet()){
                SocketChannel temp = entry.getValue();
                if ( !client.equals(temp) ){
                    sBuffter.clear();
                    sBuffter.put(charset.encode(getClientName(client) + ":" + info));
                    sBuffter.flip();
                    temp.write(sBuffter);
                }
            }
        }

    }

    private String getClientName(SocketChannel client){
        Socket socket = client.socket();
        return "[" + socket.getInetAddress().toString().substring(1) + ":" + Integer.toHexString(client.hashCode()) + "]";
    }


    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer(8888);
        server.listen();
    }


}
