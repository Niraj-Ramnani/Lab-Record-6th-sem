
for i = 1:6
    a = imread(sprintf("office_%d.jpg", i));  
    

    subplot(6, 2, 2*i-1);  
    imhist(a);  
    
    b = histeq(a);
    subplot(6, 2, 2*i);  
    imhist(b);  
    
end

sgtitle("Histogram and Equalized histogram")