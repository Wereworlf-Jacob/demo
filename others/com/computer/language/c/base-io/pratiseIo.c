#include<stdio.h>
main(){

    /**
     * 注意：使用getchar()之后，会一直输入，linux使用ctrl+d 命令来结束输入，相当于exit命令
     */

    /*统计空格，制表符与换行符个数的程序*/
    printf("请在光标后输入内容，用于测试统计内容中，空格，制表符，换行符出现的次数，CTRL+D 结束输入\n");
    int blanks, tabs, newLines; //定义空格，制表符，换行个数的变量
    //需要进行初始化，否则会出现精度丢失问题
    blanks = 0;
    tabs = 0;
    newLines = 0;
    int c; //定义用于读取输入内容的变量
    while((c = getchar()) != EOF){
        //注意，使用''单引号，表示一个整型值，对应ASCII字符集，比如\n=10，A = 65, a = 97
        if(c == ' ') ++blanks; //读取到空格符，则空格变量+1
        if(c == '\t') ++tabs; //读取到制表符，则制表符变量+1
        if(c == '\n'){
            ++newLines; //读取到换行符，则换行符变量+1
        }
    }
    printf("Blanks:\t%d\n", blanks);
    printf("Tabs:\t%d\n", tabs);
    printf("NewLines:\t%d\n", newLines);

    /*编写一个将输入复制到输出的程序，并将其中连续的多个空格用一个空格代替。*/
    printf("请在光标后输入内容，用于测试连续多个空格替换成一个空格，CTRL+D 结束输入\n");
    int lastChar; //定义变量用于记录上一个读取到的字符记录是什么
    while((c = getchar()) != EOF && c != '\n'){ //输入回车，退出循环
      //判断如果读取到了空格，并且上一次读取到的不是空格，那么就输出该字符（也就是空格）
      if(c == ' ')
        if(lastChar != c) //如果上一个字符也是空格，那么就说明空格已经输出过了，就不再输出了，相当于else
          putchar(c);
      if(c != ' ') //如果读取到的字符不是空格，那么正常输出
        putchar(c);
      lastChar = c; //输出之后，在读取下一个字符之前，将该字符记录到上一个字符变量中
    }
    printf("\n");

    /**
     * 编写一个将输入复制到输出的程序，并将其中的制表符替换为\t, 把回退符替换为\b, 把反斜杠替换为 \\.
     * 这样可以将制表符和回退符以可见的方式显示出来。
     */
     printf("请在光标后输入内容，用于测试将制表符，回退符，反斜杠替换为转义字符，CTRL+D 结束输入\n");
     while((c = getchar()) != EOF && c != '\n'){
       if(c == '\t') printf("\\t");
       if(c == '\b') printf("\\b");
       if(c == '\\') printf("\\\\");
       else putchar(c);
     }
     printf("\n");
}