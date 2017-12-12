#include <stdio.h>
#include "stdlib.h"

int main(int argc, char *argv[])
{
  FILE *fi = NULL;
  int c,z;
  int ch;
  char st[256];
  float a;

  if (argc > 1)
  {
    fi= fopen(argv[1],"rb");
  }
  else
  {
    char filename[256];

    printf("File name not found. Enter file name: ");
    scanf("%s",filename );
    fi=fopen(filename,"rb");
  }
  if (fi==NULL)
  {
    printf("Can't read this file");
    exit;
  }

  for (int i=0;(z=getc(fi))!=-1;i++)
  {
    ungetc(z,fi);
    fread("&ch",sizeof(int),1,fi);
    fread("s",sizeof(char),256,fi);
    fread("%a",sizeof(float),1,fi);

    printf("pkt. %d \t %d \t %s \t %f \n",i+1,ch,st,a);
  }
}
