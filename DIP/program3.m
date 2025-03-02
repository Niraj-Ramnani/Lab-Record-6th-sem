// Write a program to perform arithmetic operations on RGB images 
i = imread ("coloredChips.png");
j = imread("fabric.png");
c = imresize(i,[200 200]);
d = imresize(j,[200 200]);
e = imadd(c,d);
f = imsubtract(c,d);
g = imdivide(c,d);
h = immultiply(c,d);
subplot(3,2,1);
imshow(c) , title("chips");
subplot(3,2,2);
imshow(d) , title("fabric");
subplot(3,2,3);
imshow(e) , title("additon");
subplot(3,2,4);
imshow(f) , title("substraction");

subplot(3,2,5);
imshow(g) , title("multiplication");
subplot(3,2,6);
imshow(h) , title("division");