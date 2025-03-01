a = imread("cameraman.jpeg");
a = imresize(a,[200,200]);
imshow(a);
b = imread("coloredChips.png");
subplot(1,2,2);
imshow(b);