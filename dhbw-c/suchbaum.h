
struct tnode **searchrec(struct tnode *, int);

enum MODE
{
	INORDER,
	PREORDER,
	POSTORDER
};

typedef struct tnode Node;

struct tnode
{
	int value;			 /* Knoteninhalt */
	struct tnode *left;  /* linker Teilbaum */
	struct tnode *right; /* rechter Teilbaum */
};