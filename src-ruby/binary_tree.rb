class BinaryTree
  attr_accessor :root

  def initialize data_stream
    @root = BTNode.new data_stream.shift
    @data_stream = data_stream
    populate(@root)
  end

  def populate root
      queue = []
      queue.push(root)
      while(!queue.empty?) do
        root = queue.shift
        if root
          insert root
          queue.push(root.left)
          queue.push(root.right)
        end
      end
  end

  def insert root
    unless @data_stream.empty?
      root.left = BTNode.new(@data_stream.shift)
      root.right = BTNode.new(@data_stream.shift)
    end
  end
end
class BTNode
  attr_accessor :left,:right,:data
  def initialize data=nil, left=nil, right=nil
    @data = data
    @left = left
    @right = right
  end

  def height
    root = self
    left_height = root.left ? root.left.height : 0
    right_height = root.right ? root.right.height : 0
    [left_height,right_height].max + 1
  end

  def width
    (2**height)-1
  end

  def to_s
    root = self
    return root.data.to_s if root.left.nil? and root.right.nil?

    str = root.left.to_s + "----" + root.right.to_s
    "----" + root.data.to_s + "-----" + "\n|        |\n" + str
  end
end