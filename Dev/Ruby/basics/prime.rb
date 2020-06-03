def isPrime(num)
    div = 2;
    while (div*div <= num)
        if(num % div == 0)
            return false;
        end;
        div = div + 1;
    end;

    return true;
end;

a = isPrime(11);
puts "11 is prime " + a.to_s();

def allPrimes(num)
    for i in (2..num)
        if(isPrime(i))
            puts i
        end;
    end;
end;

allPrimes(10)