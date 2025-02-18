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
imshow(e) , title("add");
subplot(3,2,4);
imshow(f) , title("sub");

subplot(3,2,5);
imshow(g) , title("mul");
subplot(3,2,6);
imshow(h) , title("div");