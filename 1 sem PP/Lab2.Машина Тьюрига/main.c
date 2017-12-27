#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define COMMAND_PRINT		0
#define COMMAND_PRINT_ASCII 1
#define COMMAND_MOVE_LEFT	2
#define COMMAND_MOVE_RIGHT	3
#define COMMAND_INCREMENT	4
#define COMMAND_DECREMENT	5
#define COMMAND_LOOP_START	6
#define COMMAND_LOOP_END	7
#define COMMAND_USER_INPUT	8

struct node {
	struct node *ptr_l;
	struct node *ptr_r;

	unsigned char value;
};

struct node *create_node(void);
struct node *move_l(struct node *);
struct node *move_r(struct node *);
void node_inc(struct node *);
void node_dec(struct node *);
void print_node_value(struct node *);
void print_node_value_ascii(struct node *);
void write_user_input_to_node(struct node *);

int *get_commands_from_file(char config_file[]);

void execute(int commands[], struct node *, int current_index);

int main(int argc, char *argv[])
{
	int *command_list = NULL;

	if (argc > 1)
		command_list = get_commands_from_file(argv[1]);
	else
	{
		printf("Error: filename with commands not provided!\n");
		exit(1);
	}

	struct node *current_node = create_node();

	execute(command_list, current_node, 0);

	return 0;
}

void execute(int commands[], struct node *n, int current_index)
{
	int i, num_loops;

	for (i = current_index; commands[i] != -1; i++)
	{
		/* printf("Index: %d Command: %d Value: %d\n", i, commands[i], n->value); */
		switch (commands[i]){
			case COMMAND_PRINT:
				print_node_value(n);
				break;

			case COMMAND_PRINT_ASCII:
				print_node_value_ascii(n);
				break;

			case COMMAND_MOVE_LEFT:
				n = move_l(n);
				break;

			case COMMAND_MOVE_RIGHT:
				n = move_r(n);
				break;

			case COMMAND_INCREMENT:
				node_inc(n);
				break;

			case COMMAND_DECREMENT:
				node_dec(n);
				break;

			case COMMAND_LOOP_START:
				while (n->value != 0) execute(commands, n, i + 1);

				i++;
				for (num_loops = 1; num_loops > 0; i++)
				{
					if (commands[i] == -1) return;
					else if (commands[i] == COMMAND_LOOP_START) num_loops++;
					else if (commands[i] == COMMAND_LOOP_END)	num_loops--;
				}
				i--;

				break;

			case COMMAND_LOOP_END:
				return;

			case COMMAND_USER_INPUT:
				write_user_input_to_node(n);
				break;
		}
	}
}

struct node *create_node(void)
{
	struct node *n = malloc(sizeof(struct node));
	n->value = 0;

	return n;
}

struct node *move_l(struct node *n)
{
	if (n->ptr_l == NULL)
	{
		n->ptr_l = create_node();
		n->ptr_l->ptr_r = n;
	}

	return n->ptr_l;
}

struct node *move_r(struct node *n)
{
	if (n->ptr_r == NULL)
	{
		n->ptr_r = create_node();
		n->ptr_r->ptr_l = n;
	}

	return n->ptr_r;
}

void node_inc(struct node *n)
{
	if (n->value == 255)
	{
		printf("Warning: reached max node value. Setting from 255 to 0\n");
		n->value = 0;
	}
	else
		n->value++;
}

void node_dec(struct node *n)
{
	if (n->value == 0)
	{
		printf("Warning: reached min node value. Setting from 0 to 255\n");
		n->value = 255;
	}
	else
		n->value--;
}

void print_node_value(struct node *n)
{
	printf("%d\n", n->value);
}

void print_node_value_ascii(struct node *n)
{
	printf("%c\n", n->value);
}

void write_user_input_to_node(struct node *n)
{
	char c;

	printf("Enter char: ");
	scanf("%c", &c);
	getchar();

	n->value = c;
}

int *get_commands_from_file(char *filename)
{
	/* 
	 * Reads commands from file and returns pointer to
	 * int array with command indexes
	 */

	unsigned int i, j;
	size_t commands_capacity = 16;
	int *commands = malloc(commands_capacity * sizeof(int));

	FILE *f = fopen(filename, "r");

	if (f == NULL)
	{
		printf("Error: could not read file %s! Exiting.", filename);
		exit(1);
	}

	int c;
	char line[256];  /* line len is guaranteed to be <= 255 + \0 */

	for (i = j = 0; (c = getc(f)) != EOF; i++, j = 0)
	{
		if (c == ' ' || c == '\t') ungetc(c, f);

		while (c == ' ' || c == '\t')
		{
			c = getc(f);
		}

		if (c == '*')  /* pass commented lineI */
		{
			while (c  != '\n' && c != EOF)
			{
				c = getc(f);
				if (c == EOF) break;
			}

			i--;
			continue;
		}

		line[j] = c;
		j++;

		while ((c  = getc(f)) != EOF && c != '\n')
		{
			if (c != ' ' && c != '\t')
			{
				line[j] = c;
				j++;
			}
		}

		line[j] = '\0';

		if (i + 2 > commands_capacity)
		{
			commands_capacity *= 2;;
			commands = realloc(commands, commands_capacity * sizeof(int));
		}

		if (strcmp(line, "print") == 0)
			commands[i] = COMMAND_PRINT;
		else if (strcmp(line, "printc") == 0)
			commands[i] = COMMAND_PRINT_ASCII;
		else if (strcmp(line, "movl") == 0)
			commands[i] = COMMAND_MOVE_LEFT;
		else if (strcmp(line, "movr") == 0)
			commands[i] = COMMAND_MOVE_RIGHT;
		else if (strcmp(line, "inc") == 0)
			commands[i] = COMMAND_INCREMENT;
		else if (strcmp(line, "dec") == 0)
			commands[i] = COMMAND_DECREMENT;
		else if (strcmp(line, "begin") == 0)
			commands[i] = COMMAND_LOOP_START;
		else if (strcmp(line, "end") == 0)
			commands[i] = COMMAND_LOOP_END;
		else if (strcmp(line, "get") == 0)
			commands[i] = COMMAND_USER_INPUT;
		else
		{
			printf("Error: unknow command! (%s)", line);
			exit(1);
		}
	}

	commands[i] = -1;  /* indicate end of array */

	return commands;
}
