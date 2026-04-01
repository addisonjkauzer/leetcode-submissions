class SnakeGame {

    Queue<Integer[]> food;

    Deque<Integer[]> snake;

    Set<String> blocked;

    int width;

    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.food = new LinkedList<>();
        for (int[] position : food) {
            this.food.offer(new Integer[]{position[0], position[1]});
        }
        snake = new LinkedList<>();
        snake.offerFirst(new Integer[]{0,0});

        blocked = new HashSet<>(Arrays.asList("0,0"));

        this.width = width;
        this.height = height;
        
    }
    
    public int move(String direction) {
        Integer[] currentPosition = snake.peekFirst();
        Integer[] currentFood = food.peek();
        Integer[] newPosition = new Integer[]{0, 0};
        switch (direction) {
            case "R":
                newPosition = new Integer[]{currentPosition[0], currentPosition[1] + 1};
                break;
            case "L":
                newPosition = new Integer[]{currentPosition[0], currentPosition[1] - 1};
                break;
            case "U":
                newPosition = new Integer[]{currentPosition[0] - 1, currentPosition[1]};
                break;
            case "D":
                newPosition = new Integer[]{currentPosition[0] + 1, currentPosition[1]};
                break;
        }
        String newPositionString = newPosition[0] + "," + newPosition[1];
        System.out.println(newPositionString);
        if (newPosition[0] < 0 || newPosition[0] >= height || newPosition[1] < 0 || newPosition[1] >= width) {
            return -1;
        }
        Integer[] snakeTail = snake.pollLast();
        blocked.remove(snakeTail[0] + "," + snakeTail[1]);



        if (currentFood != null && newPosition[0] == currentFood[0] && newPosition[1] == currentFood[1]) {
            food.poll();
            snake.offerLast(snakeTail);
            blocked.add(snakeTail[0] + "," + snakeTail[1]);
        }
        if (blocked.contains(newPositionString)) {
            return -1;
        } else {
            snake.offerFirst(newPosition);
            blocked.add(newPositionString);
        }
        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
