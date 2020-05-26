#include<stdio.h>
main(){
    float fahr, celsius;
    float step, upper;
    upper = 300;
    step = 20;
    fahr = 0;
    printf("%3s\t%6s\n", "华氏度", "摄氏度");
    while(fahr <= upper){
        //使用int的时候，要先乘，后除以9，因为5/9 int计算会舍弃小数点后数据，5/9 = 0
        //注意，在运算时5/9 两个整型计算，会按整型计算，这样会丢失精度
        //fahr - 32.0 fahr是float，如果使用32，那么会自动调整为使用float计算，但是为了更好地阅读，使用32.0来显式地计算
        celsius = (5.0/9.0) * (fahr - 32.0);
        //%3.0 表示宽度为3，不保留小数点；6.2表示宽度为6并保留小数点后2位
        printf("%3.0f\t%6.2f\n", fahr, celsius);
        fahr += step;
        //printf函数 %o 八进制 %x 十六进制 %c 字符 %s 字符串 %% 表示百分号
    }
}