class LinkedList
  attr_accessor :head,:tail
  def populate range=(1..10)
    array = range.to_a.shuffle
    @head = LLNode.new array[0]
    iterator = @head
    array.each do |data|
      iterator = iterator.add(data)
    end
    @tail = iterator
  end
end

class LLNode
  attr_accessor :next, :data

  def initialize(data=nil, nextt=nil)
    @data = data
    @next = nextt
  end

  def add data
    @next = LLNode.new(data)
  end

  def to_s
    str = data.to_s
    temp = @next
    while(temp)
      str = str + "-->" + temp.data.to_s
      temp = temp.next
    end
    str
  end
end