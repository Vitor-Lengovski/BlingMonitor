package resources;


import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class GetCameraUrls {
//
//    //String[] urls;
//    final List<Future<String>> urls = new ArrayList<>();
//   // public static List<String> futures = new ArrayList<String>();
//    public  void main(int startIp, int endIp, int startPort, int endPort) throws Exception {
//        //System.out.println("start");
//
//        String ipv4Ip = localIP();
//
//        String ipCutted = getIpWithoutHost(ipv4Ip);
//        final ExecutorService executorService = Executors.newFixedThreadPool(40);
//        final int TIMEOUT = 200;
//
//
//       // final ExecutorService executorService = Executors.newFixedThreadPool(100);
//        //final List<Future<Boolean>> futures = new ArrayList<>();
//        for (int ipTest = startIp; ipTest <= endIp; ipTest++) {
//            for (int portTest = startPort; portTest <= endPort; portTest++) {
//                urls.add(openPort(ipCutted + ipTest, portTest, TIMEOUT, executorService));
//                //System.out.println(ipTest+portTest);
//            }
//        }
//        executorService.shutdown();
//
//
////        try {
////            FXMLLoader loader = new FXMLLoader(GetCameraUrls.class.getResource("../FxmlScreens/baseScreen.fxml"));
////            Parent root = (Parent) loader.load();
////            FinalScreenController finalScreenController = loader.getController();
////            //finalScreenController.addCamera(ip, port);
////            finalScreenController.scanFinished();
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        int portasAbertas = 0;
//
//        for (final Future<String> url : urls) {
//            if (url.get() ) {
//                portasAbertas++;
//            }
//        }
//
//        System.out.println(urls.size());
//
//    }
//
//
//    public static Future<String> openPort(final String ip, final int port, final int timeout, final ExecutorService es) {
//        return es.submit(new Callable<String>() {
//            @Override
//            public String call() {
//                try {
//                    Socket socket = new Socket();
//                    socket.connect(new InetSocketAddress(ip, port), timeout);
//                    System.out.println(ip+port);
//
////
//                    socket.close();
//                    return ip+port;
//
//                } catch (Exception ex) {
//                    return null;
//                }
//            }
//        });
//    }


    public static List<String> main(int startIp, int endIp, int startPort, int endPort) throws Exception {
        final List<String> urls = new ArrayList();
        final ExecutorService es = Executors.newFixedThreadPool(200);

        String ipv4Ip = localIP();

        String ipCutted = getIpWithoutHost(ipv4Ip);
        final int timeout = 200;
        final List<Future<ScanResult>> futures = new ArrayList<>();
        for (int ipTest = startIp; ipTest <= endIp; ipTest++) {
           for (int portTest = startPort; portTest <= endPort; portTest++) {

            // for (int port = 1; port <= 80; port++) {
            futures.add(portIsOpen(es, ipCutted + ipTest, portTest, timeout));
        }}
        es.awaitTermination(200L, TimeUnit.MILLISECONDS);
        int openPorts = 0;
        for (final Future<ScanResult> f : futures) {
            if (f.get().isOpen()) {
                openPorts++;
                urls.add(f.get().getPort());
            }
        }
        //System.out.println("There are " + openPorts + " open ports on host " + ip + " (probed with a timeout of  + timeout + "ms)");
        return urls;
    }

    public static Future<ScanResult> portIsOpen(final ExecutorService es, final String ip, final int port,
                                                final int timeout) {
        return es.submit(new Callable<ScanResult>() {
            @Override
            public ScanResult call() {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, port), timeout);
                    socket.close();
                    return new ScanResult(ip,port, true);
                } catch (Exception ex) {
                    return new ScanResult(ip,port, false);
                }
            }
        });
    }

    public static class ScanResult {
        private int port;
        private String ip;
        private boolean isOpen;

        public ScanResult(String ip,  int port, boolean isOpen) {
            super();
            this.ip = ip;
            this.port = port;
            this.isOpen = isOpen;
        }

        public String getPort() {
            return ip+":"+port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public boolean isOpen() {
            return isOpen;
        }

        public void setOpen(boolean isOpen) {
            this.isOpen = isOpen;
        }

    }

    public static String localIP() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostAddress();
    }

    public static String getIpWithoutHost(String fullIp){
        StringBuilder ipReverse;
        ipReverse = new StringBuilder(fullIp).reverse();
        String ipCutted  = ipReverse.toString();
        ipCutted = ipCutted.substring(ipCutted.indexOf("."), ipCutted.length());
        return new StringBuilder(ipCutted).reverse().toString();
    }
}
