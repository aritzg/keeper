json.array!(@images) do |image|
  json.extract! image, :file_name, :format, :width, :height
  json.url image_url(image, format: :json)
end
