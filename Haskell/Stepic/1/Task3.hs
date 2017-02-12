sum'n'count :: Integer -> (Integer, Integer)
sum'n'count x | x == 0 = (0, 1)
              | otherwise = sum'n'count' (abs x)

sum'n'count' x | x == 0 = (0, 0)
               | otherwise = let
    pref = sum'n'count' (x `div` 10)
    x1 = fst pref + (x `mod` 10)
    x2 = snd pref + 1
    in (x1, x2)