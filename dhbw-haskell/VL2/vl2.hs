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
isPrime n = if n < 2 then False else isPrimeL n (n-1)
isPrimeL x y = if ( y > 1  && mod x y == 0 ) then False else ( if (y == 1) then True else isPrimeL x (y - 1) )
-- b) 
--getPrimes :: [Num]
getPrimes = [ x | x <- [2..], isPrime x]

-- Übung 3 

-- Übung 4
--toListOfLists :: [a] -> [[a]]


-- Übung 5 
--listStringConcat :: [String] -> String

-- Übung 6
--a)
data BBaum a = LeererBaum
                | Knoten a (BBaum a) (BBaum a)
                deriving Show

-- Testobjekt
unterbaum = (Knoten 4 (Knoten 1 LeererBaum LeererBaum) (Knoten 5 LeererBaum LeererBaum))
baum = Knoten 2 (Knoten 3 LeererBaum LeererBaum) (unterbaum)

--b)
mapTree f (LeererBaum) = LeererBaum
mapTree f (Knoten b bl br) = Knoten (f b) (mapTree f bl) (mapTree f br)

--c) 
flatBBaum :: BBaum a -> [a]
flatBBaum LeererBaum = []
flatBBaum (Knoten b bl br) = [b] ++ flatBBaum bl ++ flatBBaum br