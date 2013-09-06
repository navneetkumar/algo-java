require './linked_list'
class Algorithm
  def run
    linked_list
  end

  def linked_list
    ll = LinkedList.new
    ll.populate
    puts ll.head
  end
end

algorithm = Algorithm.new

algorithm.run
