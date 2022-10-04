public class AssignmentOneFinished{

    public static void main(String[] args){
        int[] smallArray;
        int[] largeArray;
        
        int lengthOfArray;
        int sizeOfArray = 0;
        long start;
        long timeTest;
        long time;

        int amountRuns = 29;
        int amountIncrease;
        int lengthMod;
        int steps = 1024 * 1024 * 64;

        if(args.length < 2 || args.length > 2){
            System.out.println("Proper Usage is: java AssignmentOneFinished <StartSizeArray> <Multiplier>");
            System.out.println("Recommended: java AssignmentOneFinished 1 2");
            System.exit(0);
        }

        //args
        int userStartLengthOfArray = Integer.parseInt(args[0]);
	double multiplier = Double.parseDouble(args[1]);


        //Complete 4 runs
        for(int l = 0; l < 4; l++){
            System.out.println("Run: " + (l + 1) + "\n");

            lengthOfArray = userStartLengthOfArray; //length of array 
            //sizeOfArray = lengthOfArray * 4;
            timeTest = 0;
    
            for(int j = 0; j < amountRuns; j++){
		if(lengthOfArray > 250000000){
			break;
		}
                lengthMod = lengthOfArray - 1;

                for(int i = 0; i < 50; i++){

                    smallArray = new int[1];
                    largeArray = new int[lengthOfArray];

                    //load variable we're testing into cache
                    smallArray[0]++;

                    //load large array into cache
                    for(int k = 0; k < steps; k++){
                        largeArray[(k * 16) & lengthMod]++; 
                    }

                    //time access to the cache
                    start = System.nanoTime();
                    smallArray[0]++;
                    time = System.nanoTime() - start;
                    timeTest += time;
                }
                sizeOfArray = lengthOfArray * 4;

                System.out.println((float)timeTest/50.0 + "," + sizeOfArray);
                timeTest = 0;
                lengthOfArray = (int)Math.ceil((double)lengthOfArray * multiplier);
            }
            System.out.println("");
        }
    }
}
