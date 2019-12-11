package doodleblue10_12_19; //  here doodleblue10_12_19 is a package
                            //  it is a package so we write the 1st letter as small, and more than one word so dot is used.
/**
 *
 * @author Selvabharathi S
 * THEORY
 *         1) It is the way or some rule to follow, how to write the name
 * of variable, constant, function/method, class, package etc.
 *         2) It is not necessary to follow at all time, that's why they
 * named it as convention and not as rules.
 *         3) some default java naming conventions rules are.
 *              1) name must not contain any white spaces.
 *              2) the name should not start with any special characters
 *                  like &,$,_ 
 *          4) some other rules 
 *              1) To define a CLASS and INTERFACE/name a class
 *                  > It should start with the uppercase letter.
 *                  > write class name as it relate to what it does.
 *              2) To define a METHODS/ FUNCTION.
 *                  > It should start with lowercase letter.
 *                  > if multiple names for a function is applied, only first 
 *                    word start with small letter, then followed by upper case.
 *              3) To define a VARIABLE
 *                  > It should start with small letter.
 *                  > It should not start with special characters like
 *                      &,$,_
 *                  > if multiple names for a variable, start with small letter
 *                    followed by upper case.
 *                  > avoid using one-character variable, since it wont deliver 
 *                    any meaning to easily understand, what the variable does.
 *              4) To define PACKAGE
 *                  > starts with lowercase letter.
 *                  > if multiple words, then we use dots(.) to separate them.
 *              5) To define CONSTANT
 *                  > It should be fully uppercase letters.
 *                  > if multiple words are used then we use underscore(_) in between them.
 *          5) CAMELCASE : during naming if we use multiple words,
 *                          first word will start with small letter,
 *                          remaining word start with a capital letter.
 * 
 * 
 * UNDERSTANDING/ PURPOSE OF USE
 *          if there is no such naming conventions then it will lead to
 * confusion and miss lead the code.
 *          it will become easy to read by any other developer also.
 */
public class NamingConventions // here NamingConventions is a class
                               // so we started with capital and continued for upcomming words.
{
    public static void main(String[] args) // here main is a function 
                                           // the starting word is small letter, rest of the word will start with capital.
    {
            int basketModel; // here basket is a variable, it should start with small letter,and no special character to be used.
                             // multiple words in a variable, so next word starts with upper case.
            final int PRICE_CODE; // here PRICE_CODE is a constant, which is to be fully upper case and _ to link more words.
    }
    
}
