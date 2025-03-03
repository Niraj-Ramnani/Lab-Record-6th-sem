img = imread('office_2.jpg');
r = double(img);
c = 1; 
subplot(4,2,1);
imshow(img);
title('Original Image');

gamma_values = [0.6, 0.4, 0.2, 2,4,6];

for k = 1:length(gamma_values)
    g = gamma_values(k);
    
 
    s = c * (r .^ g);
    t = 255/(c * (255 .^g));
    o = uint8(t * s);
    subplot(4,2,k+1);
    imshow(o);
    title(['Gamma = ', num2str(g)]);
end