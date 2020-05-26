#include<stdio.h>

#define WORD_IN 1
#define WORD_OUT 0
#define WORD_MAX_LENGTH 15

main(){

    /**
     * 绘制单词长度的直方图：x = 单词长度 y = 该长度单词出现的次数
     */
    //定义循环变量，单词长度
    int i, j, wordLength = 0;
    int overflowWord = 0; //定义单词长度超过单词最大长度的个数
    //定义获取输入字符的变量
    int c;
    //定义单词分组数组，下标为单词长度，值为单词个数
    int wordGroup[WORD_MAX_LENGTH];
    //数组初始化
    for(i = 0; i < WORD_MAX_LENGTH; ++i){
        wordGroup[i] = 0;
    }
    int state = WORD_OUT; //定义单词截取状态，初始是在单词外
    //获取输入的内容
    while((c = getchar()) != EOF){
        //如果遇到空格，换行，制表符，说明是另外一个单词了
        if(c == ' ' || c == '\n' || c == '\t'){
            //如果此前，在单词里面，说明读取到了单词内容，那么需要保存单词长度对应的值+1
            if(state == WORD_IN){
                //如果单词没有超长，那么给数据里面的值+1
                if(wordLength <= WORD_MAX_LENGTH){
                    ++wordGroup[wordLength - 1];
                    state = WORD_OUT;
                } else { //如果单词超长了，那么记录溢出单词1个
                    ++overflowWord;
                }
                wordLength = 0;
            }
            //如果在单词外面，说明仍然没有读取到单词，则继续读取
        } else { //如果未读取到空，那么说明拿到了单词，记录在单词里面了，同时单词数量+1
            state = WORD_IN;
            ++wordLength;
        }
    }

    //定义y轴最大值为0
    int yMaxValue = 0;
    /*获取某长度，单词数量最多的一个值，作为y轴max*/
    for(i = 0; i < WORD_MAX_LENGTH; ++i){
        if(wordGroup[i] > yMaxValue){
            yMaxValue = wordGroup[i];
        }
    }

    //打印直方图，外层循环打印y轴，内层循环打印x轴
    for(i = yMaxValue; i >= 1; --i){
        printf("%4d|", i);
        for(j = 0; j < WORD_MAX_LENGTH; ++j){
            if(wordGroup[j] >= i){
                printf("**  ");
            } else {
                printf("    ");
            }
        }
        printf("\n");
    }

    printf("%4s|", "len");
    //打印横坐标的值，单词长度
    for(i = 0; i < WORD_MAX_LENGTH; ++i){
        printf("%-4d", i + 1);
    }
    printf("\n");

    printf("%4s|", "num");
    //打印该单词长度对应的单词数量值
    for(i = 0; i < WORD_MAX_LENGTH; ++i){
        printf("%-4d", wordGroup[i]);
    }
    printf("\n");

    printf("The overflow word num is: %d\n", overflowWord);

}