CREATE VIEW detail_VIEW  AS

SELECT d.*,e.fecha Fecha, p.descripcion Descripcion FROM detail d JOIN evaluacion e ON e.id= d.evaluacion_id
JOIN preguntas p ON p.id= d.preguntas_id;

