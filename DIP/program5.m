// Write a program in matlab to perform image scaling , rotation and translation
f = imread("coloredChips.png");
i = imtranslate(f,[15,25]);
j = imrotate(f,30);
k = imresize(f,0.5);
subplot(1,3,1);
imshow(i),title('translation');
subplot(1,3,2);
imshow(j),title('Rotation');
subplot(1,3,3);
imshow(k),title('Scaling');
size(k)
size(i)