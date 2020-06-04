import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class URLreader {

    private final String prot="http://";
    int len=prot.length();
    public boolean check(String URl,int depth){
        if (URl.length()<10)
        return false ;
        String s="";
        { if ((depth > 0) && (depth < 80)) {
                if (URl.substring(0, len).equals(prot)){
                    s=URl.substring(len+1);
                    if (s.length()>0)

                        return true;
                }
            }
        }
        return false;
    }
    protected void Reading(URLDephPair site,vebScanner veb)
    {try{
        if (check(site.getURL(),site.getDepth())==true)
        {URL s=new URL(site.getURL());
        String host=s.getHost();
        String path=s.getPath();
            Socket sitechek=new Socket(host,80);
            OutputStream outStream = sitechek.getOutputStream();
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(outStream));
            writer.print("GET "+path + "HTTP/1.1\n" +
                            "Host:" +host+"\n");

            writer.flush();
        ScanSite Scun=new ScanSite();
        Scun.Scanning(sitechek.getInputStream());
        for (String siteLine: Scun.getLine()){
            if (check(siteLine,site.getDepth()-1)){
                if (!(veb.getScanned().contains(siteLine))){
                    if (!(veb.getNotScanned().contains(siteLine))){
                        URLDephPair site2=new URLDephPair(siteLine,site.getDepth()-1);
                        veb.addNotScanned(site2);}
                }


            }

        }
        veb.addScanned(site);

        sitechek.close();
        }
        veb.remove();
        }
    catch (SocketException ex){
        veb.remove();
    }
   catch (IOException ex1){
        veb.remove();
    }
    }
}
