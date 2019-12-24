import java.io.*;
import java.net.*;
class TCPServer {
    public static void main(String args[]) throws Exception{
        String clientSentence;
        String captializedSentence;
        //comment in java
        //welcomeSocket is listening to the port 6789
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            captializedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(captializedSentence);
        }
    }
}