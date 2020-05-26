#include<stdio.h>
main(){
  int tempF, tempC; //定义华氏度，摄氏度变量
  int step, end; //温度进度步长，结束温度
  tempC = -14;//摄氏度从-14开始
  end = 148;
  step = 20;
  printf("%s\t%s\t\n", "摄氏度", "华氏度"); //输出表头
  printf("%3s\t%6s\t\n", "摄氏度", "华氏度");//指定宽度，使表格内容右对齐
  while(tempC <= end){ //一直循环到结束温度，结束计算
    tempF = tempC * 9 / 5 + 32;//根据当前摄氏温度计算华氏温度
//    printf("%d\t%d\t\n", tempC, tempF);//输出计算温度
    printf("%3d\t%6d\t\n", tempC, tempF);//指定宽度，使表格内容右对齐
    tempC += step;//摄氏度按步长增长
  }
}