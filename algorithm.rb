base_dir = File.join(File.dirname(__FILE__),"src-ruby","*.rb")
Dir[base_dir].each do |file|
  require file
end

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

require 'pry'; pry
