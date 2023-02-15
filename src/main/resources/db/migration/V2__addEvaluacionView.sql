CREATE VIEW evaluacion_VIEW  AS

SELECT e.*,u.nombre usuario FROM evaluacion e JOIN usuario u ON u.id= e.usuario_id ;

