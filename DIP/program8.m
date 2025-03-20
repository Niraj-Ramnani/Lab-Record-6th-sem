sgtitle('Images ');
for i = 1:6
    a = imread(sprintf("office_%d.jpg", i));  
    subplot(3, 2, i); 
    imshow(a);  
end

for i = 1:6
    a = imread(sprintf("office_%d.jpg", i));  
    subplot(3, 2, i); 
    imhist(a);  
end
sgtitle('Histograms of the images ');