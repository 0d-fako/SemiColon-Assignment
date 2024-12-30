firstNumberInRange = int(input("Enter starting value x: "))
     
lastNumberInRange = int(input("Enter ending value y: "))
      
        
divisor = int(input("Enter divisor p: "))
        
                
firstDivisible = firstNumberInRange;

while firstDivisible % divisor != 0: 
            firstDivisible++
        
        
       
count = 0;
if firstDivisible <= lastNumberInRange:
         lastDivisible = lastNumberInRange - (lastNumberInRange % divisor)
            
count = ((lastDivisible - firstDivisible) / divisor) + 1
        
      
print(f"The number of divisible in the range is: {count}");
        
