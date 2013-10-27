# Given a board of snakes and ladders game, provide an algorithm to
# find the minimum number of dice rolls required to reach 100 from 1
class Board
  attr_accessor :array, :cost

  def initialize range = 1..100, ladders = { 5=>20, 4 => 35, 6 => 93 }, snakes = { 98=>3}
    @range = range
    @ladders = ladders
    @snakes = snakes
    @cost = []
    @array = []

    @range.each do |index|
      @array[index] = index
      @cost[index] = 100
    end
    @ladders.each_pair do |index,value|
      @array[value] = index
    end
    @snakes.each_pair do |index,value|
      @array[value] = index
    end
  end

  def get_min
    (1..6).each do |cost_at|
      @cost[cost_at] = 1
    end
    (7..100).each do |index|
      @cost[index] = min_cost_at index
    end
    @cost[100]
  end

  def cost_at position
    if @array[position] != position
      @cost[@array[position]]
    else
      @cost[position]
    end
  end

  def min_cost_at position
    range = (position-6..position-1)
    cost_array = []
    range.each do |index|
      cost_array.push(cost_at(index)+1)
    end
    cost_array.push(cost_at position)
    cost_array.min
  end

end

board = Board.new
board.get_min
