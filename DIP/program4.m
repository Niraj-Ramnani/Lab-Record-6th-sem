// Write a program in matlab to find negative transform of an image 
clc;
close all;
I = imread("coloredChips.png");
I = rgb2gray(I);
[m n] = size(I);
for q = 1:n
    for p = 1:m
        I2(p , q) = 225 - I(p,q);
    end
end
I1 = imread("coloredChips.png");
subplot(2,1,1);
imshow(I1),title('original');
subplot(2,1,2);
imshow(I2),title('negative');