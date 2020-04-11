package LO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Set;

public class NIOClient {

    private InetSocketAddress SERVER;

    private ByteBuffer rBuffer = ByteBuffer.allocate(1024);

    private ByteBuffer sBuffer = ByteBuffer.allocate(1024);

    private static Selector selector;

    private Charset charset = Charset.forName("UTF-8");

    public NIOClient(int port){
        SERVER = new InetSocketAddress("127.0.0.1", port);
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void init() throws IOException {

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);

        selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(SERVER);

        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> handle(selectionKey));
            selectionKeys.clear();
        }

    }

    private void handle(SelectionKey selectionKey){
        try {
            if ( selectionKey.isConnectable() ){
                SocketChannel client = (SocketChannel) selectionKey.channel();
                if ( client.isConnectionPending() ){
                    client.finishConnect();
                    System.out.println("连接成功");
                    new Thread(){
                        @Override
                        public void run() {
                            while (true){
                                try {
                                    sBuffer.clear();
                                    Scanner scanner = new Scanner(System.in);
                                    String sendText = scanner.nextLine();
                                    System.out.println(sendText);
                                    sBuffer.put(charset.encode(sendText));
                                    sBuffer.flip();
                                    client.write(sBuffer);
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.start();
                }
                client.register(selector, SelectionKey.OP_READ);
            } else if (selectionKey.isReadable()){

                SocketChannel client = (SocketChannel) selectionKey.channel();
                rBuffer.clear();
                int count = client.read(rBuffer);
                if ( count > 0 ){
                    String reciveText = new String(rBuffer.array(), 0, count);
                    System.out.println(reciveText);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NIOClient(8888);
    }

}
