package geym.java.training.ch12.hw;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class CliHandler {
    IIndexIO indexIO;

    @Autowired
    public IIndexIO getIndexIO() {
        return indexIO;
    }

    public void setIndexIO(IIndexIO indexIO) {
        this.indexIO = indexIO;
    }

    public void handleCmd(){
        Scanner scaner=new Scanner(System.in);
        while(scaner.hasNextLine()){
            String line=scaner.nextLine();
            List<FileBean> re=indexIO.find(line);
            if(re==null || re.isEmpty()){
                System.out.println("没有找到");
                continue;
            }
            for(FileBean file:re){
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
