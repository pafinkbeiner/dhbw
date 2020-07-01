-- IMPORTS
import Data.List
import System.IO

-- test variables
testList = [1,3,5,6,3,8]
laenge = length testList
test = last testList

-- Übung 1
-- a)
lastElement :: [a] -> a
lastElement (x:[]) = x
lastElement (x:xs) = lastElement xs
-- b)
stripList :: [a] -> [a]
stripList (x:xs) = again (reverse xs)
again (x:xs) = reverse xs
-- c)
--isPalindrom :: (Eq a) => [a] -> Bool
isPalindrom [] = True
isPalindrom (_:[]) = True
isPalindrom (l) = if (head l) == (lastElement l) then isPalindrom (stripList(l)) else False

-- Übung 2
-- a)
--isPrime :: Num -> Bool
primes = [ x | x <- [1..], isPrime x]
isPrime (n) = 