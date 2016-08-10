## Learning Python

#%% Class definition

class BinaryTreeNode:

    def __init__(self, value):
        self.value = value
        self.left  = None
        self.right = None
        
    def __repr__(self, level=0):
        ret = "\t"*level+repr(self.value)+"\n"
        if (self.left):
            ret += self.left.__repr__(level+1)
            
        if (self.right):
            ret+= self.__repr__(level+1)
            
        return ret

    def insert_left(self, value):
        self.left = BinaryTreeNode(value)
        return self.left

    def insert_right(self, value):
        self.right = BinaryTreeNode(value)
        return self.right
        
t = BinaryTreeNode(10)
t.insert_left(15)
t.insert_right(3)
print(t)