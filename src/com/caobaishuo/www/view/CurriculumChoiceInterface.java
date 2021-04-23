package com.caobaishuo.www.view;
import com.caobaishuo.www.service.CurriculumChoiceMethod;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurriculumChoiceInterface extends JFrame {

// 创建一个选课界面
    public static void main() {
        JFrame jFrame=new JFrame("选课");
        jFrame.setLayout(null);
        jFrame.setBounds(400,400,400,400);
        JLabel jLabel=new JLabel("课程代号");
        jLabel.setBounds(50,50,80,50);
        jFrame.add(jLabel);
        JTextField jTextField=new JTextField();
        jTextField.setBounds(100,60,150,30);
        jFrame.add(jTextField);
        JLabel jLabel1=new JLabel("周数");
        jLabel1.setBounds(50,100,80,50);
        jFrame.add(jLabel1);
        JTextField jTextField1=new JTextField();
        jTextField1.setBounds(100,110,150,30);
        jFrame.add(jTextField1);
        JLabel jLabel2=new JLabel("星期");
        jLabel2.setBounds(50,150,80,50);
        jFrame.add(jLabel2);
        JTextField jTextField2=new JTextField();
        jTextField2.setBounds(100,160,150,30);
        jFrame.add(jTextField2);
        JLabel jLabel3=new JLabel("时间");
        jLabel3.setBounds(50,200,80,50);
        jFrame.add(jLabel3);
        JTextField jTextField3=new JTextField();
        jTextField3.setBounds(100,210,150,30);
        jFrame.add(jTextField3);
        JButton jButton=new JButton("确定");
        jButton.setBounds(125,280,60,50);
        jFrame.add(jButton);
        jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        jFrame.setVisible(true);
        jButton.addActionListener(new ActionListener() {      //为按钮添加响应
            @Override
            public void actionPerformed(ActionEvent e) {
                CurriculumChoiceMethod curriculumChoiceMethod=new CurriculumChoiceMethod();  //创建一个类并给里面的变量赋予输入框里面的值
                curriculumChoiceMethod.setCode(jTextField.getText());
                curriculumChoiceMethod.setWeek(jTextField1.getText());
                curriculumChoiceMethod.setDay(jTextField2.getText());
                curriculumChoiceMethod.setTime(jTextField3.getText());
                try {
                   if(curriculumChoiceMethod.Judge()){            //调用Judge方法判断选课是否规范
                       JOptionPane.showMessageDialog(null,"选课成功");
                       jFrame.setVisible(false);
                   }
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
    }
}
