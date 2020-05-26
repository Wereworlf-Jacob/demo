#include<stdio.h>
main(){

    /*int c; //定义一个int变量，用来存放getchar()输入字符，因为最后要包含一个EOF，所以c容量要足够大，所以用int，不用char
    while((c = getchar()) != EOF){ //从c中读取字符，一直读取到末尾EOF
        putchar(c);//输出c中的字符
    } //如此就实现了一个复制输入内容的一个程序*/

    int b;
    b = EOF;
    printf("EOF的值=%d\n", b); //EOF的值输出出来 = -1

    int a;
    a = getchar() != EOF; // != 的运算优先级要比 = 高，所以不用加小括号
    printf("getchar() != EOF 的值=%d\n", a); //该判断的值输出 = 1
}