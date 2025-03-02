// Write a program in matlab to read and display gray/images of different format 
a = imread("cameraman.jpeg");
a = imresize(a,[200,200]);
imshow(a);
b = imread("coloredChips.png");
subplot(1,2,2);
imshow(b);