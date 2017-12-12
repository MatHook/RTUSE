#include <stdio.h>
#include <stdlib.h>

char str[256];
FILE *f=NULL;
int get_code(char *comm);
struct chss
{
   unsigned char mem;
   struct chss* right;
   struct chss* left;
};
struct chss* chs;
void process_command(int code);
int process_line();
int main(int argc, char *argv[])
{
  chs = (struct chss*)malloc(sizeof(struct chss));
  chs -> left = NULL;
  chs -> right = NULL;
  chs -> mem = 0;

  if (argc != 2)
  {
    printf("File name not found");
  }
    else
    {
      f = fopen(argv[1],"r");
    }

    if(f)
    {
      while(!feof(f))
      {
        process_command(process_line());
      }
    }
    else
    {
      printf("\n Can't read this file");
    }
    fclose(f);
    return 0;
}

int process_line()
{
  int index = 0;
  if (!feof(f))
  {
    fgets(str, sizeof(str),f);
    while((str[index] == '\t') || (str[index] == ' '))
    {
      index++;
    }
    return get_code(str + index);
  }
  return 0;
}
int get_code(char * comm){
    if((comm[0] == 'm') && (comm[3] == 'l'))    /*command -> movl*/
        {
          return 1;
        }
    if((comm[0] == 'm') && (comm[3] == 'r'))    /*command -> movr*/
        {
          return 2;
        }
    if (comm[0] == 'i')   /*command -> inc*/
        {
          return 3;
        }
    if (comm[0] == 'd')   /*command -> dec*/
        {
          return 4;
        }
    if((comm[0] == 'p') && (comm[5] == 'c'))   /*command -> printc*/
        {
          return 7;
        }
    if(comm[0] == 'p')   /*command -> print*/
        {
          return 5;
        }
    if(comm[0] == 'g')   /*command -> get*/
        {
          return 6;
        }
    if(comm[0] == 'b')   /*command -> begin*/
        {
          return 8;
        }
    if(comm[0] == 'e')   /*command -> end.*/
        {
          return 9;
        }
    return 0;
}
void process_command(int code)
{
  switch(code)
  {
    case 1:
    if (chs -> left != NULL)
    {
      chs = chs -> left;
    }
    else
    {
      struct chss* temp = chs;
      chs -> left = (struct chss*)malloc(sizeof(struct chss));
      chs = chs -> left;
      chs -> mem = 0;
      chs -> right = temp;
      chs -> left = NULL;
    }
    break;
    case 2:
    if(chs -> right != NULL)
    {
      chs = chs-> right;
    }
    else
    {
      struct chss* temp = chs;
            chs -> right = (struct chss*)malloc(sizeof(struct chss));
            chs = chs -> right;
            chs -> left = temp;
            chs -> mem = 0;
            chs -> right = NULL;
    }
    break;
    case 3:
    if (chs -> mem == 255)
    {
      chs -> mem = 0;
      printf("chs memory is too large \n");
    }
    else
    {
      chs -> mem++;
    }
    break;
    case 4:
        if(chs -> mem != 0)
            {
              chs -> mem --;
            }
        break;
    case 5:
        printf("%d \n", chs -> mem);
        break;
    case 6:
        {
            printf("Please enter a number 0 to 255 ");
            unsigned int temp;
            scanf("%u", &temp);
            chs -> mem = temp;
            printf("\n");
        }
        break;
    case 7:
        printf("%c \n", (chs -> mem));
        break;
    case 8:
        {
            int i = 0;
            char s[256];
            s[0] = process_line();
            while((s[i] != 9) && (!feof(f)))
            {
                process_command(s[i]);
                i++;
                s[i] = process_line();
            }
            int max = i;
            while(chs -> mem)
            {
                for(i = 0; i < max; i++)
                {
                    process_command(s[i]);
                }
            }
        }
        break;
  }
}
