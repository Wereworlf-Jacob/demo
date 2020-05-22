//根据公式 摄氏度=(5/9)*(华氏度-32) 打印华氏度与摄氏度对照表
#include <stdio.h>
/* 当fahr = 0, 20, 30 ..., 300时，
 * 分别打印华氏温度与摄氏温度对照表
 */
main()
{
  //在C语言中，所有变量都必须先声明，后使用。
  //char 字符 short 短整型 long 长整型 double 双精度浮点型 float 浮点型
  int fahr, celsius; //定义fahr 华氏温度，celsius摄氏温度
  int lower, upper, step;
  lower = 0;   //温度表的下限
  upper = 300; //温度表的上限
  step = 20;   //步长

  fahr = lower;
  printf("%s\t%s\n", "华氏度", "摄氏度");
  while(fahr <= upper){
    celsius = 5 * (fahr - 32) / 9;
    printf("%d\t%d\n", fahr, celsius);
    fahr = fahr + step;
  }
}