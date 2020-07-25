package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;

public class StreamDemo
{
    public static Integer sum(List<Integer> number){
        return number.stream().mapToInt(Integer::valueOf).sum();
    }

    public static List<String> filterList(List<String> list){
        return list.stream().filter(i->i.charAt(0) == 'a' && i.length() == 3).map(i->i.toString()).collect(Collectors.toList());
    } 

    static Predicate<String> isPalindrome = i->IntStream.range(0,i.length()/2).allMatch(p->i.charAt(p) == i.charAt(i.length() - p - 1));

    public static List<String> filterListPalindrome(List<String> list){
        return list.stream().filter(i->isPalindrome.test(i)).collect(Collectors.toList());
    }

    public static void main( String[] args )
    {
        List<Integer> intList = Arrays.asList(12 , 56 , 76 , 15 , 56 , 15) ;
		List<String> stringList1 = Arrays.asList("abs",  "abb" , "asdvdf" , "Adsd" , "Adc") ;
        List<String> stringList2 = Arrays.asList("aabaa" , "aBcBa" , "aaadaa" , "ascasc" , "MalayalaM" , "Sdcdw")  ;
        
        int s = sum(intList);
        List<String> filteredAList = filterList(stringList1);
        List<String> filteredPalindromeList = filterListPalindrome(stringList2); 

        System.out.println(s);
        filteredAList.forEach(System.out ::println);
        filteredPalindromeList.forEach(System.out :: println);
    }
}
