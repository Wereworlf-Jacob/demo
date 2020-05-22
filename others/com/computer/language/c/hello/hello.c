//包含标准库的信息
#include <stdio.h>
//定义名为main的函数，它不接受参数值
main()
{ //main函数的语句都被括在花括号中
    //main函数调用库函数printf以显示字符序列；
    printf("hello, world;\nthe second out \n "); //\n代表换行符
    //printf 永远不会换行，以下方式2和上面的输出内容格式是一样的
    printf("hello,");
    printf(" world;");
    printf("\n");
    printf("the second out \n");
    //\a 无变化 \b 退格（向前删除一个字符） \t 相当于table键 \v 垂直制表符（换行然后和上一行末尾字符对其）\n 换行
}