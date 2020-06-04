import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class vebScanner {
    private LinkedList<URLDephPair> Scanned=new LinkedList<URLDephPair>();
    private LinkedList<URLDephPair> NotScanned=new LinkedList<URLDephPair>();
    public static void main (String args[]) {
        Scanner Str=new Scanner(System.in);
    URLreader scan=new URLreader();
    URLDephPair site=new URLDephPair(Str.nextLine(),Str.nextInt());
vebScanner Al =new vebScanner();
Al.addNotScanned(site);
while (Al.getNotScanned().isEmpty()!=true)
{
    scan.Reading(Al.getNotScanned().getFirst(),Al);
}
try{File file=new File("Links.txt");
FileWriter writefile=new FileWriter(file);
BufferedWriter writer =new BufferedWriter(writefile);
String line;
    for (URLDephPair lines:Al.getScanned()
         ) {
        line=lines.getURL()+" "+String.valueOf(lines.getURL())+"\n";
        writefile.write(line);

        System.out.println(lines.getURL());

    }
  writefile.close();

}catch (IOException ex2){
    ex2.printStackTrace();
}
    }

    public LinkedList<URLDephPair> getNotScanned() {
        return NotScanned;
    }

    public LinkedList<URLDephPair> getScanned() {
        return Scanned;
    }
    public void addScanned(URLDephPair site){
        Scanned.add(site);
    }
    public void addNotScanned(URLDephPair site){
        NotScanned.add(site);
    }
    public void remove(){
        this.NotScanned.removeFirst();
    }
}
