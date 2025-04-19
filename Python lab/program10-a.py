# Write a program to implement Merge sort.
def merge_sort(arr):
     if len(arr) <= 1:
          return arr
     mid = len(arr) // 2
     left_half = merge_sort(arr[:mid])
     right_half = merge_sort(arr[mid:])
     return merge(left_half, right_half)


def merge(left, right):
     res = []
     i = j = 0
     while i < len(left) and j < len(right):
          if left[i] < right[j]:
               res.append(left[i])
               i += 1
          else:
               res.append(right[j])
               j += 1
     res.extend(left[i:])
     res.extend(right[j:])
     return res
n = int (input("Enter number of elements: "))
arr = []
print("Enter elements:")
for i in range(n):
    arr.append(int(input()))
print("Unsorted array:", arr) 
arr = merge_sort(arr)
print("Sorted array:", arr)