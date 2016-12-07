package net.khe.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hyc on 2016/11/30.
 * 龟兔赛跑动画
 */
public class Race extends JFrame{
    private Player rabbit = new Rabbit(1000,(int distance)->updateRabbit(distance));
    private Player turtle = new Turtle(1000,(int distance)->updateTurtle(distance));
    private JPanel showPanel = new ShowPanel();
    private BufferedImage cache = new BufferedImage(600,100,BufferedImage.TYPE_INT_ARGB);
    private ImageIcon rabbitImg = new ImageIcon("race_img/rabbit.png");
    private ImageIcon turtleImg = new ImageIcon("race_img/turtle.png");
    private ExecutorService exec = Executors.newCachedThreadPool();
    public void updateRabbit(int distance){
        int x = distance/2;
        Graphics g = cache.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,cache.getWidth(),cache.getHeight()/2);
        g.setColor(Color.RED);
        g.drawLine(500,0,500,100);
        g.drawImage(rabbitImg.getImage(),x,10,
                rabbitImg.getIconWidth(),rabbitImg.getIconHeight(),null);
        showPanel.repaint();
    }
    public void updateTurtle(int distance){
        int x = distance/2;
        Graphics g = cache.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,60,cache.getWidth(),cache.getHeight()/2);
        g.setColor(Color.RED);
        g.drawLine(500,0,500,100);
        g.drawImage(turtleImg.getImage(),x,60,
                turtleImg.getIconWidth(),turtleImg.getIconHeight(),null);
        showPanel.repaint();
    }
    class ShowPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            g.drawImage(cache,0,0,cache.getWidth(),cache.getHeight(),null);
        }
    }
    public Race(){
        setTitle("龟兔赛跑");
        setSize(600,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(BorderLayout.CENTER,showPanel);
        setVisible(true);
        showPanel.setBackground(Color.WHITE);
        Graphics g = cache.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,cache.getWidth(),cache.getHeight());
        showPanel.repaint();
        exec.execute(rabbit);
        exec.execute(turtle);
        boolean gameOverFlag = false;
        while (!gameOverFlag){
            if(rabbit.isGameOver()){
                exec.shutdownNow();
                gameOverFlag = true;
                JOptionPane.showMessageDialog(
                        this,
                        "兔子赢了",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            if(turtle.isGameOver()){
                exec.shutdownNow();
                gameOverFlag = true;
                JOptionPane.showMessageDialog(
                        this,
                        "乌龟赢了",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        new Race();
    }
}
interface UpdateRace{
    void update(int distance);
}
abstract class Player implements Runnable{
    private int distance = 0;
    private int overallLength;
    private boolean isGameOver = false;
    private UpdateRace updateRace;
    public abstract int speed();
    public abstract int restInterval();
    public abstract int restTime();
    public Player(int overallLength,UpdateRace updateRace){
        this.overallLength = overallLength;
        this.updateRace = updateRace;
    }
    public void run(){
        try{
            while (!Thread.interrupted()&&distance<=overallLength){
                updateRace.update(distance);//更新显示
                distance+=speed();//增加移动距离
                //System.out.println(distance);
                if(restInterval()>0&&distance%restInterval()==0){
                    //判断是否需要休息
                    TimeUnit.MILLISECONDS.sleep(restTime()/10);
                }
                //线程睡眠1秒再更新显示
                TimeUnit.MILLISECONDS.sleep(100);
            }
            isGameOver = true;
        }catch (InterruptedException e){
            System.out.println("Game Over!");
        }
    }

    public synchronized boolean isGameOver() {
        return isGameOver;
    }
}
class Rabbit extends Player{

    public Rabbit(int overallLength, UpdateRace updateRace) {
        super(overallLength, updateRace);
    }

    @Override
    public int speed() {
        return 5;
    }

    @Override
    public int restInterval() {
        return 20;
    }

    @Override
    public int restTime() {
        return 500;
    }
}
class Turtle extends Player{

    public Turtle(int overallLength, UpdateRace updateRace) {
        super(overallLength, updateRace);
    }

    @Override
    public int speed() {
        return 1;
    }

    @Override
    public int restInterval() {
        return 100;
    }

    @Override
    public int restTime() {
        return 500;
    }
}