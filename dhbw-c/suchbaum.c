#include "suchbaum.h"
#include <stdio.h>
#include <stdlib.h>

Node *talloc(void) { return (Node *)malloc(sizeof(Node)); }

/* addelement: neuen Knoten einfuegen */
Node *addelement(Node *p, int i)
{
	if (p == NULL)
	{
		p = talloc(); /* make a new node */
		p->value = i;
		p->left = p->right = NULL;
	}
	else if (p->value == i)
	{
		return p;
	}
	else if (i < p->value)
	{
		p->left = addelement(p->left, i);
	}
	else
	{
		p->right = addelement(p->right, i);
	}
	return p;
}

/* loescht Knoten mit allen Soehnen */
int deletenoderec(Node *p)
{
	if (p == NULL)
		return 0;
	else
	{
		deletenoderec(p->left);
		deletenoderec(p->right);
		p->left = NULL;
		p->right = NULL;
		free(p);
		return 0;
	}
}

/*Fügt zwei Suchbäume zu einem Zusammen  */
Node *addtree(Node *top, Node *p)
{
	if (p == NULL)
		return top;
	else
		return addtree(addtree(addelement(top, p->value), p->right), p->left);
}

void delete_node(Node **node)
{
	struct tnode *old = *node;

	if ((*node)->left == NULL && (*node)->right == NULL)
	{ // Node is leaf
		*node = NULL;
	}
	else if ((*node)->left == NULL)
	{ // Node has no left child
		*node = (*node)->right;
	}
	else if ((*node)->right == NULL)
	{ // Node has no right child
		*node = (*node)->left;
	}
	else
	{ // Node has both children

		*node = addtree((*node)->left, (*node)->right);
	}

	free(old);
}

void delete (Node **node, int value)
{
	if ((*node) == NULL)
	{
		printf("Tree is empty");
	}
	else if ((*node)->value == value)
	{
		delete_node(node);
	}
	else if ((*node)->value > value)
	{
		delete (&((*node)->left), value);
	}
	else
	{
		delete (&((*node)->right), value);
	}
}

void print_tree(Node *node, int level, int direction)
{
	if (node != NULL)
	{
		if(level > 0) {
			for (int i = 0; i < level - 1; i++)
			{
				printf("  ");
			}
			printf("%c%c", 192, 196);
		}
		char dir = direction == 1 ? 'l' : direction == -1 ? 'r' : ' ';
		printf("%d %c\n", node->value, dir);

		level++;
		print_tree(node->left, level, 1);
		print_tree(node->right, level, -1);
	}
}

int main(int argc, char const *argv[])
{
	/*Graphen aufbauen */
	struct tnode *baum = addelement(NULL, 5);
	addelement(baum, 2);
	addelement(baum, 1);
	addelement(baum, 3);
	addelement(baum, 7);
	addelement(baum, 6);
	addelement(baum, 10);
	addelement(baum, 8);
	addelement(baum, 12);
	addelement(baum, 9);

	print_tree(baum, 0, 0);

	return 0;
}
