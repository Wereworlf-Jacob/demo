#include<stdio.h>

/**
 * 在编写代码过程中直接使用 20, 300, 0, 5.9 这种“幻数”是非常不合理的
 * 会给代码阅读带来难度。
 * 使用define关键字，程序中所有在#define中定义的名字，都将用相应的替换文本替换
 * 注意：1、define关键字不是变量，所以写在 main的外面
 *      2、define 定义替换文本，每行末尾不需要加分号，名字和替换文本之间用空格隔开
 *      3、名字，通常使用大写字母，方便代码阅读
 */
#define STEP 20
#define UPPER 300
#define START 0

main(){

    float fahr, celsius;
    printf("%3s\t%6s\n", "华氏度", "摄氏度");
    //for循环，c99编译器才支持for(int i = 0;;)这种写法，linux gcc不支持这个
    for(fahr = START; fahr <= UPPER; fahr += STEP){
        printf("%3.0f\t%6.2f\n", fahr, (5.0/9.0)*(fahr-32));
    }

}