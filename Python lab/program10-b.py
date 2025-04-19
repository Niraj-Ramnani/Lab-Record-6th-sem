#Write a program to implement Selection sort, Insertion sort
def selection_sort(arr):
     n = len(arr)
     for i in range (n):
          min = i
          for j in range (i +1 , n):
               if arr[j] < arr[min]:
                    min = j
          arr[i],arr[min] = arr[min],arr[i]
     return arr
def insertion_sort(arr):
     n = len(arr)
     for i in range (1,n):
          key = arr[i]
          j = i-1
          while j>=0 and arr[j]> key:
               arr[j+1] = arr[j]
               j -= 1
          arr[j+1] = key
     return arr
n = int(input("Enter number of elements "))
print("Enter the elements of the array ")
arr = []
for i in range (n):
     arr.append(int(input()))
print("Unsorted array " , arr)
s_arr = selection_sort(arr)
print("array after selction sort " , s_arr)
i_arr = insertion_sort(arr)
print("array after selction sort " , i_arr)