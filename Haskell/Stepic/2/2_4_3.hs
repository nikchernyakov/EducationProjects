class (Enum a) => SafeEnum a where
  ssucc :: a -> a
  ssucc a | a == maxBound  
  
  spred :: a -> a
  spred (minBound a) = maxBound a
  spred a = pred a